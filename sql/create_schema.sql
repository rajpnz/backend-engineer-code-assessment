-- Create the schema and table for the backend engineer coding assessment
-- TODO: Use flyway to create schema

-- Create Schema
CREATE SCHEMA IF NOT EXISTS coding_assessment;

-- Create the account table in that schema
CREATE TABLE coding_assessment.account
(
    id                VARCHAR(36)  NOT NULL,
    account_number    VARCHAR(36)  NOT NULL,
    customer_name     VARCHAR(100) NOT NULL,
    account_nick_name VARCHAR(30),
    CONSTRAINT pk_account PRIMARY KEY (id),
    CONSTRAINT uk_account_account_number UNIQUE (account_number)
);

-- Index for customer name lookups
CREATE INDEX idx_account_customer_name ON coding_assessment.account (LOWER(customer_name));

-- Create the application user (replace the password placeholder)
CREATE USER savings_user WITH PASSWORD 'REPLACE_THIS_PLACEHOLDER';

-- Allow user to connect to the database
GRANT CONNECT ON DATABASE postgres TO savings_user;

-- Allow user to use the schema
GRANT USAGE ON SCHEMA coding_assessment TO savings_user;

-- Grant table-level privileges needed by the app (CRUD)
GRANT SELECT, INSERT, UPDATE, DELETE ON coding_assessment.account TO savings_user;

-- Ensures savings_user automatically gets the same privileges on any schema changes
ALTER DEFAULT PRIVILEGES IN SCHEMA coding_assessment
    GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO savings_user;