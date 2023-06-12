classDiagram

    Cliente --> Emprestimo
    Emprestimo --> Livro
    
    class Emprestimo{
        -dataEmprestimo: OffsetDateTime
        -dataPrevistaParaDevolucao: OffsetDateTime
        -dateDevolucao: OffsetDateTime
        -notificarAtrasaso()
    }
    
    class Cliente{
        -nome: String
        -cpf: String
        -email: String

        -inserir()
        -consultar()
        -excluir()
        -alterar()
    }

    class Livro {
        -titulo: String
        -ISBN: String
        -descricao: String
        -autor: String
        -genero: String
        -ano: Date
        -status: Status
        
        -inserir()
        -consultar()
        -excluir()
        -alterar()
    }

    