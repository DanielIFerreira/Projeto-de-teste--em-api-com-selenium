#language:pt

  @categoria
  Funcionalidade: Consulta Categoria
    Cenario: Realizar Consulta Categoria com Sucesso
      Dada que tenha realizado o login com dados validos
      E que tenha um playload da API de Categoria
      Quando realizo uma requisicao do tipo GET de Categoria
      Entao valido que recebo um status 200 no response
      E valido que no campo "tipo[2]" possui o valor "Terror"

    @ConsultarcategoriaSemoToken
      Cenario: Realizar Consulta Categoria Sem o Token
        Quando realizo uma requisicao do tipo GET de Categoria
        Entao valido que recebo um status 403 no response
        E valido que no campo "message" possui o valor "Access Denied"