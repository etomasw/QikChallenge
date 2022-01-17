# Software-Challenge
REST API Using Spring-Boot framework.
H2 Database (built-in memory database, no need to setup)

# MODELS
  - Product
  - Promotion (Actually we have three types of promotions)
  - BasketItem
  - Basket

# PRODUCT
  - LIST ALL THE PRODUCTS http://localhost:8080/products
  - GET CERTAIN PRODUCT BY UUID http://localhost:8080/products/{UUID}
  - UPDATE A PRODUCT BY UUID http://localhost:8080/products/update/{UUID}
# PROMOTION
  - LIST ALL THE PROMOTIONS http://localhost:8080/promotions
  - CREATE A PROMOTION http://localhost:8080/promotions
    http://localhost:8080/promotions/create?type=BUY_X_GET_Y_FREE&requiredQuantity=2&freeQuantity=1
  - ADD A PROMOTION TO A PRODUCT http://localhost:8080/promotions/add/{idPromotion}
    {
        "id": "PWWe3w1SDU" // Product ID to add the promotion
    }
# BASKET ITEM
  - LIST ALL THE BASKET ITEMS http://localhost:8080/basket-item/
  - CREATE A BASKET ITEM http://localhost:8080/basket-item/add
    {
    "quantity": 3,
    "product" : {
        "pId": 3
      }
    }
# BASKET
  - LIST ALL THE BASKET http://localhost:8080/basket/info/1
  - ADD BASKET ITEM TO BASKET http://localhost:8080/basket/add/{basketId}/{basketItemId}
