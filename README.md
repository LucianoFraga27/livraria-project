# Projeto de Livraria

Este é um projeto simples para uma livraria, com o objetivo de gerenciar empréstimos de livros para clientes. O projeto utiliza classes como `Emprestimo`, `Cliente`, `Livro`, `Autor` para representar as entidades relacionadas à livraria.

## Modelo Entidade Relacionamento 

> **Observação**: É importante destacar que o MER (Modelo Entidade-Relacionamento) está em constante evolução, uma vez que estou aprendendo a utilizar a ferramenta mermaid para representá-lo. Neste estágio inicial, o MER pode não refletir com total fidelidade o que está sendo desenvolvido e está sujeito a modificações e ajustes futuros.

A seguir, apresentamos o MER atualizado do projeto:

```mermaid
erDiagram
    autor ||--|| livro_autor: ""
    livro_autor }|--|| livro : ""
    livro ||--|| emprestimo : ""
    cliente ||--|{emprestimo: ""
    emprestimo {
        Long id_livro
        Long id_cliente
        OffsetDateTime dataEmprestimo
        OffsetDateTime dataPrevistaDevolucao
        OffsetDateTime dataDevolucao
    }
    livro {
        Long id
	String ISBN
        String titulo
        String descricao
	String genero
        String editora
        Enum status
        Date dataPublicacao
    }
    autor {
        Long id
        String nome
    }
    livro_autor {
        Long id_autor
        Long id_livro
    }
    cliente {
        Long id
        String nome
        String email
        String cpf
    }
```

## Funcionalidades

O projeto de livraria possui as seguintes funcionalidades:

- **Livro**: A Entidade `Livro` representa um livro registrado na livraria, com informações como título, ISBN, descrição, gênero, ano de publicação e status(EMPRESTADO, DISPONIVEL). Possui métodos para inserir, consultar, excluir e alterar informações do livro.

- **Cliente**: A Entidade `Cliente` representa um cliente da livraria, contendo informações como nome, CPF e email. Possui métodos para inserir, consultar, excluir e alterar informações do cliente.

- **Emprestimo**: A Entidade `Emprestimo` representa o empréstimo de um livro, contendo informações sobre a data de empréstimo, a data prevista para devolução e a data de devolução efetiva. Além disso, possui um método para notificar atraso.

- **Autor**: A Entidade `Autor` representa um autor de livros, contendo informações como nome. É associada aos livros por meio de uma relação. Podendo ter uma ou mais autores.
 

As funcionalidades mencionadas permitem que a livraria gerencie empréstimos de livros, cadastre e gerencie clientes, controle informações sobre os livros disponíveis, bem como associe autores e editoras aos livros.

> **Observação**: Este projeto está em desenvolvimento. Ao finalizar o projeto, serão apresentados os endpoints disponíveis para interação com a API. Atualizações serão feitas neste README para fornecer as informações necessárias sobre como utilizar e interagir com a aplicação. Fique atento para futuras atualizações!



