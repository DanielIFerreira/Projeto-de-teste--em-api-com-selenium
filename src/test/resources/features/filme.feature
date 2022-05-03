#language: pt

  @filme
  Funcionalidade: CRUD Filme
    Contexto:
      Dado que tenha realizado o login com dados validos
      E que tenha um playload da API de Filme

    @cadastroFilme
    Cenario: Cadastro Filme
      Quando realizo uma requisicao do tipo POST de Filme
      Entao valido que recebo status 201 no response
      E valido que no campo "categorias.tipo[1]" possui o valor "Comédia"
      E armazeno o id que recebo do response de Filme

    @consultarFilme
    Cenario: Consulta Filme
      Quando  realizo uma requisicao do tipo GET de Filme
      Entao valido que recebo status 200 no response
      E valido que no campo "categorias[0].tipo[1]" possui o valor "Comédia"

    Cenario: Alteracao Filme
      E altero o indice 1 da lista de categorias de filme com os valores
        |tipo|Terror|
      Quando  realizo uma requisicao do tipo PUT de Filme
      Entao valido que recebo status 200 no response
      E valido que no campo "categorias.tipo[1]" possui o valor "Terror"

    Cenario: Consulta Filme apos alteracao
      Quando  realizo uma requisicao do tipo GET de Filme
      Entao valido que recebo status 200 no response
      E valido que no campo "categorias[0].tipo[1]" possui o valor "Terror"

    Cenario: Deletar Filme
      Quando  realizo uma requisicao do tipo DELETE de Filme
      Entao valido que recebo status 200 no response

    Cenario: Consulta Filme apos exclusao
      Quando  realizo uma requisicao do tipo GET de Filme
      Entao valido que recebo status 200 no response
      E valido que rece uma lista vazia no response
