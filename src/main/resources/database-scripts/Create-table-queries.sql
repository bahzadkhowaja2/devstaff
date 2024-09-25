CREATE TABLE crop_type (
    id BIGSERIAL PRIMARY KEY,
    crop_name VARCHAR(255)
);

CREATE TABLE farm (
    id BIGSERIAL PRIMARY KEY,
    farm_name VARCHAR(255)
);

CREATE TABLE field (
    id BIGSERIAL PRIMARY KEY,
    field_name VARCHAR(255),
    farm_id BIGINT NOT NULL,
    FOREIGN KEY (farm_id) REFERENCES farm(id)
);

CREATE TABLE harvested (
    id BIGSERIAL PRIMARY KEY,
    season VARCHAR(255),
    crop_type_id BIGINT NOT NULL,
    actual_amount DOUBLE PRECISION,
    field_id BIGINT NOT NULL,
    FOREIGN KEY (crop_type_id) REFERENCES crop_type(id),
    FOREIGN KEY (field_id) REFERENCES field(id)
);

CREATE TABLE planted (
    id BIGSERIAL PRIMARY KEY,
    season VARCHAR(255),
    crop_type_id BIGINT NOT NULL,
    planted_area VARCHAR(255),
    expected_amount DOUBLE PRECISION,
    field_id BIGINT NOT NULL,
    FOREIGN KEY (crop_type_id) REFERENCES crop_type(id),
    FOREIGN KEY (field_id) REFERENCES field(id)
);

