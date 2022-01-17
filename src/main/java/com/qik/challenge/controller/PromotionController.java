package com.qik.challenge.controller;

import com.qik.challenge.enums.PromotionType;
import com.qik.challenge.model.Product;
import com.qik.challenge.model.Promotion;
import com.qik.challenge.model.promotions.FlatPromotion;
import com.qik.challenge.model.promotions.GetFreePromotion;
import com.qik.challenge.model.promotions.QuantityPromotion;
import com.qik.challenge.repository.FlatPromotionRepository;
import com.qik.challenge.repository.GetFreePromotionRepository;
import com.qik.challenge.repository.QuantityPromotionRepository;
import com.qik.challenge.service.ProductService;
import com.qik.challenge.service.PromotionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/promotions")
public class PromotionController {

    private PromotionService promotionService;
    private ProductService productService;

    private Logger LOGGER = LoggerFactory.getLogger(PromotionController.class);

    @Autowired
    public PromotionController(PromotionService promotionService, ProductService productService) {
        this.promotionService = promotionService;
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Promotion>> getPromotions() {
        return new ResponseEntity<>(promotionService.findAll(), OK);
    }

    /** Create a promotion via Query Params */
    @PostMapping("/create")
    public ResponseEntity<Promotion> createPromotion(@RequestParam(name = "type") PromotionType promotionType, @RequestParam(value = "percentDiscount", required = false) Integer percentDiscount,
                                                     @RequestParam(value = "requiredQuantity", required = false) Integer requiredQuantity, @RequestParam(value = "freeQuantity", required = false) Integer freeQuantity,
                                                     @RequestParam(value = "price", required = false) Integer price) {
        switch (promotionType.name()) {
            case "FLAT_PERCENT":
                FlatPromotion flatPromo = new FlatPromotion(promotionType, percentDiscount);
                LOGGER.info("Received FLAT_PERCENT promo of disccount type: " + percentDiscount);
                return new ResponseEntity<>(promotionService.create(flatPromo), OK);
            case "BUY_X_GET_Y_FREE":
                GetFreePromotion getFree = new GetFreePromotion(promotionType, requiredQuantity, freeQuantity);
                LOGGER.info("Received BUY_X_GET_Y_FREE promo of type: " + promotionType.name());
                return new ResponseEntity<>(promotionService.create(getFree), OK);
            case "QTY_BASED_PRICE_OVERRIDE":
                QuantityPromotion qtyPromo = new QuantityPromotion(promotionType, requiredQuantity, price);
                LOGGER.info("Received QTY_BASED_PRICE_OVERRIDE promo of type: " + promotionType.name());
            default:
                return new ResponseEntity<>(null, NOT_FOUND);
        }
    }

    /** Add a promotion to a certain product ID obtained from the request body message **/
    @PostMapping("/add/{id}")
    public ResponseEntity<Promotion> addPromotion(@PathVariable("id") Long promotionId, @RequestBody Product product) {
        Promotion promotion = promotionService.findById(promotionId);
        Product p = productService.findByUUID(product.getId());
        p.getPromotions().add(promotion);
        productService.update(p);
        return new ResponseEntity<>(promotion, OK);
    }


}
