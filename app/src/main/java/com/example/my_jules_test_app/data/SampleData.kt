package com.example.my_jules_test_app.data

import com.example.my_jules_test_app.data.model.Product
import com.example.my_jules_test_app.data.model.ProductType

object SampleData {
    val products = listOf(
        Product(
            id = 1,
            name = "Apple",
            price = 1.99,
            imageName = "apple.png",
            benefits = "Rich in fiber and antioxidants.",
            uses = "Eating raw, baking, making juice.",
            description = "A sweet, edible fruit produced by an apple tree.",
            type = ProductType.FRUIT
        ),
        Product(
            id = 2,
            name = "Banana",
            price = 0.99,
            imageName = "banana.png",
            benefits = "Good source of potassium.",
            uses = "Eating raw, smoothies, baking.",
            description = "An elongated, edible fruit – botanically a berry – produced by several kinds of large herbaceous flowering plants in the genus Musa.",
            type = ProductType.FRUIT
        ),
        Product(
            id = 3,
            name = "Carrot",
            price = 0.79,
            imageName = "carrot.png",
            benefits = "Rich in Vitamin A.",
            uses = "Eating raw, cooking, salads.",
            description = "A root vegetable, usually orange in color, though purple, black, red, white, and yellow cultivars exist.",
            type = ProductType.VEGETABLE
        ),
        Product(
            id = 4,
            name = "Broccoli",
            price = 1.49,
            imageName = "broccoli.png",
            benefits = "Rich in vitamins K and C.",
            uses = "Steaming, roasting, stir-frying.",
            description = "An edible green plant in the cabbage family whose large flowering head, stalk and small associated leaves are eaten as a vegetable.",
            type = ProductType.VEGETABLE
        )
    )
}
