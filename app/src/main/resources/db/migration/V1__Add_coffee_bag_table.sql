CREATE TABLE coffee_bag (
    id UUID NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL,
    description text NOT NULL,
    roasting_profile varchar(50) NOT NULL,
    roasting_date date NOT NULL,
    roasting_vendor VARCHAR(200) NOT NULL,
    weight_code varchar(5) NOT NULL,
    weight_text varchar(50) NOT NULL,
    weight_value numeric NOT NULL
);