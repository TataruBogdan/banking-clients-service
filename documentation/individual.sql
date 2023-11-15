CREATE TABLE individual(
    id int GENERATED AS IDENTITY primary key,
    first_name text,
    last_name text,
    address text,
    birth_date date,
    phone_number text,
    email_address text,
    rrn text,
    employer_name text,
    occupation text
)

-- Generate some random data for the individual table
--'RRN' || id::text,
    INSERT INTO individual (id, first_name, last_name, address, birth_date, email_address, rrn, employer_name, occupation)
SELECT
    id,
    'First' || id::text,
        'Last' || id::text,
        'Address' || id::text,
        '1990-01-01'::date + (random() * 365)::integer,
        'email' || id::text || '@intecbrussel.com',
        lpad(id::text, 11, '0')::text,
        'Employer' || id::text,
        'Occupation' || id::text
FROM generate_series(1, 10) id;