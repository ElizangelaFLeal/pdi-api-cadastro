create table clientes(
        id bigint not null auto_increment,
        nome varchar(100) not null,
        email varchar(100) not null,
        cpf varchar(14) not null,
        telefone varchar (10),
        logradouro varchar(100),
        bairro varchar(100),
        cep varchar(9),
        complemento varchar(100),
        numero varchar(10),
        uf char(2),
        cidade varchar(100),

        primary key(id)

)