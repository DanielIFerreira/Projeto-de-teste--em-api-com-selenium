#language:pt

  Funcionalidade: Realizar Login
    Testes da API de Login

    Cenario: Realizar Login com sucesso
      Dado que tenha um payload validdo da API de Login
      Quando envio uma requisicao do tipo POST de Login
      Entao valido que recebo status 200 no response
      E armazeno o token que recebo do response de Login

    Cenario: Realizar Login com usuario invalido
      Dada que tenha um payload da API do Login com as seguintes informacoes
        | email| invalido@email.com |
        | senha| 123456             |
      Quando envio uma requisicao do tipo POST de Login
      Entao valido que recebo status 400 no response
      Entao valido que recebo "54545121" no