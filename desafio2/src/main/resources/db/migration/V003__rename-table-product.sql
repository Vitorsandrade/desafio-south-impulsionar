ALTER TABLE product RENAME TO tb_product;
ALTER TABLE tb_product RENAME COLUMN manufacturingdate TO manufacturing_date;
ALTER TABLE tb_product RENAME COLUMN expirationdate TO expiration_date;
ALTER TABLE tb_product RENAME COLUMN barcode TO bar_code;