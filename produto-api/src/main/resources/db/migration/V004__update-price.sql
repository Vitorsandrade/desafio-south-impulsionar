UPDATE tb_product SET price = price + (0.45 *(price + (tax / 100 * price))) + (tax / 100 * price)