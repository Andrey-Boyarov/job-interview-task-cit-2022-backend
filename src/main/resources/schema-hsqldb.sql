CREATE TABLE dict_task
(
    id bigint primary key,
    label varchar (30),
    code bigint,
    input_type bigint
);

CREATE TABLE hot_input
(
    id bigint primary key,
    task_code bigint,
    input varchar (250)
);