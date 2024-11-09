CREATE TABLE public.readers
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    name character varying(250),
    email character varying(250),
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.readers
    OWNER to postgres;