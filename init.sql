CREATE TABLE tbl_url_mapping(
    id SERIAL PRIMARY KEY,
    original_url VARCHAR(255) UNIQUE NOT NULL,
    short_url VARCHAR(20) UNIQUE NOT NULL,
    link_expiry TIMESTAMP
);

CREATE INDEX original_url ON tbl_url_mapping(original_url);
CREATE INDEX short_url ON tbl_url_mapping(short_url);