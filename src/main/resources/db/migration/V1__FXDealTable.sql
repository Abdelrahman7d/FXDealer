CREATE TABLE fx_deal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    deal_unique_id VARCHAR(255) UNIQUE,
    from_currency_iso_code VARCHAR(8) NOT NULL, -- Because the largest currency ISO code have 8 chars
    to_currency_iso_code VARCHAR(8) NOT NULL,
    deal_timestamp TIMESTAMP NOT NULL,
    deal_amount NUMERIC(10, 2) NOT NULL
);
