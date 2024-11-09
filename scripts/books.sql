CREATE TABLE public.books
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    title character varying(250),
    author character varying(250),
    "publishedDate" date,
    isbn character varying(250),
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.books
    OWNER to postgres;