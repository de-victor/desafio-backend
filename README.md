# Desafio Nucleo de Desenvolvimento da UNIFOR(NATI)

# Dependências Desenvolvimento
- Java 1.8
- Sprint Boot 2.1.x
- Maven
- MySQL 5.6

# Bibliotecas Utilizadas
- Spring boot
- Lombok
- mysql-connector
- JPA 
- Web(container)

# Aplicações Utilizadas para o desenvolvimento
- Eclipse
- Mysql Workbench
- HeidiSQL
- Postman

# Instalação e execução
É necessário ter o banco de dados mysql, utilizado a versão 5.6 neste projeto, para a parte de dados. Restaure o backup que se encontra no arquivo "desafio_db.sql" na pasta "documentacao".
Utilizando o Eclipse na guia de project explore importe como um projeto maven selecionando "Existing Maven Project", navegue até onde a pasta do repositório foi copiada e abra. Tendo como base que o maven esta configurado, o Eclipse irá puxar as dependencias do projeto.
Para a execução, navegue em src e localize o pacote br.unifor.desafiobackend, localizando a classe DesafioBackendApplication clique com o botão direito e em seguida Run As > Java Application.
O backend esta em execução na porta 8080. Conta padrão admin:

matricula:1

senha:123

token:d0572253c0e7cdb85b13988712cb152e

# Lombok
Caso o seu eclipse ainda não tenha instalado o Lombok, após a importação do projeto o eclipse irá acusar erro, isso é devido a geração dinamica de gets/sets que esta lib faz. Para instalar o lombok basta navegar em "Maven Dependencies" localizar a lib "lombok-1.18.6.js" e executalo como um aplicativo java. Uma tela irá aparecer pedindo que informe onde esta o diretorio de instalação do Eclipse, localize a pasta e finalmente clique em install. [Maiores informações sobre a lib você pode acessar aqui](https://howtodoinjava.com/automation/lombok-eclipse-installation-examples/).

# Url e acesso
O backend esta com um controle de acesso, ADMINISTRADORES só podem acessar as funcionalidades de usuario(CRUD), Coordenadores podem acessar as funcionalidades para semestre(CRUD)/Disciplina(CRUD)/MatrizCurricular(CRUD), e alunos apenas podem visulizar a matriz curricular.
Para este controle de acesso foi usado uma política de token de acesso, o token de acesso é gerado no ato do login criando um identificador daquele usuário. **É necessário na comunicação com o backend informar o token no header do pacote de envio**.
Ao cadastrar um novo usuario, acesse a url de login informando matricula e senha para saber o token de acesso daquele usuário.

##### Acesso publico
* /usuario/login - POST - {matricula:STRING, senha:STRING}

###### Acesso administrador
* /usuario - GET - retornar a lista de usuarios
* /usuario - POST - cadastra um usuario - {matricula:STRING, nome:STRING, senha:STRING, idTipo: INT}
* /usuario/{id} - DELETE - remover um usuario
* /usuario/{id} - PUT - atualizar um usuario - {id:INT, matricula:STRING, nome:STRING, senha:STRING, idTipo: INT}

###### Acesso aluno/professor
* /viewmatriz - GET - apresenta as matrizes

###### Acesso coordenador
* /curso - GET - retornar a lista de curso
* /curso - POST - cadastra um usuario - {nome:STRING, idProfessor: INT}
* /curso/{id} - DELETE - remover um curso
* /curso/{id} - PUT - atualizar um curso - {id:INT, nome:STRING, idProfessor: INT}


* /disciplina - GET - retornar a lista de disciplina
* /disciplina - POST - cadastra uma disciplina - {idCurso:INT, idProfessor:INT, cargaHoraria:INT, nome:STRING}
* /disciplina/{id} - DELETE - remover uma disciplina
* /disciplina/{id} - PUT - atualizar uma disciplina - {id:INT, idCurso:INT, idProfessor:INT, cargaHoraria:INT, nome:STRING}


* /semestre - GET - retornar um semestre
* /semestre - POST - cadastra um semestre - {ano:STRING, periodo:STRING}
* /semestre/{id} - DELETE - remover um semestre
* /semestre/{id} - PUT - atualizar um semestre - {id:INT, ano:STRING, periodo:STRING}


* /matriz - GET - retornar a lista de matriz
* /matriz - POST - cadastra elementos da matriz - {idSemestre:INT, idDisciplina:INT, idCurso:INT}
* /matriz/{id} - DELETE - um elemento da matriz
* /matriz/{id} - PUT - atualizar um elemento da matriz - {id:INT, idSemestre:INT, idDisciplina:INT, idCurso:INT}

# Modelando o banco de dados
Foi utilizado a aplicação Workbench para modelar a base de dados. O arquivo com esta modelagem se encontra dentro da pasta "documentacao" deste repositório.

![desafio_db](https://uploaddeimagens.com.br/images/001/973/437/original/desavio_db.png?1553074858)

Como pode ser visto na imagem acima, usamos a tabela usuario como nucleo da estrutura da base, nesta tabela é armazenado todos os usuário, a identificação é feita através da tabela tipo_usuario que guarda por sua vez a identificação para administrador, coordenador, professor e aluno.
A tabela curso se liga a tabela usuario para registrar quem é o coordenador responsável pelo curso cadastrado, ligamento semelhante com a tabela disciplina onde dessa vez é informado o professor da mesma além da disciplina precisar da identificação do curso a qual pertence.
Para matriz_curricular foi identificado a dependencia para qual curso, semestre e disciplina ela faz parte.



# Desenvolvendo o backend
[Utilizando um quadro de kanban](https://github.com/de-victor/desafio-backend/projects/1) do github foi possível organizar e focar nas atividades para o backend.
A estrutura de pacotes seguiu o padrão br.com.unifor.desafiobackend, apartir deste pacote base foi gerado os demais:

* br.com.unifor.desafiobackend.configs
* br.com.unifor.desafiobackend.controllers
* br.com.unifor.desafiobackend.generics
* br.com.unifor.desafiobackend.interceptors
* br.com.unifor.desafiobackend.model
* br.com.unifor.desafiobackend.repository
* br.com.unifor.desafiobackend.services
* br.com.unifor.desafiobackend.util

# Explicando as camadas
Para desenvolver foi adotado o metodo de separação de camadas, deixar de forma clara as responsábilidades de cada entidade. Assim foi usado um modelo com 4 camadas, uma camada de modelo onde esta contem o mapeamento da entidade com sua estrutura da base de dados, camada de repository esta do padrão Spring que é responsável por pegar os dados da base de dados, camada de service esta também do spring responsavel por isolar regras de negócios e finalmente a camada de controller que é a classe de "frente" do backend onde recebe as requisições da web.

# Utilização de classes genericas
No projeto foi adotado duas classes genericas, uma para Service e outra para Controller. Essa adoção tem objetivo de manter os metodos e utilização dos recursos de URL padronizados como também propor soluções genericas para metodos que possivelmente se repetem, como é o caso de CRUDs.

# Pacotes
###### configs
Pacote contendo classes de configuração, no caso configuração para CORs, crossorigen, e TiposUsuarios, uma classe com dados estáticos guardando os tipos de usuários da aplicação.

###### controllers
Pacote com as entidades anotadas como RestControllers da aplicação, são responsáveis por conter as uri de acesso

###### generics
Pacote que guarda as classes com código genérico, foi desenvolvido uma classe para deixar de forma generica e padronizada o CRUD para controller, e as classes de services

###### interceptors
Pacote que contém a classe que intercepta as requisições e guarda a lógica de negocio do controle de acesso as URI.

###### model
Pacote que guarda as entidades de modelo da aplicação

###### repository
pacote que guarda as classes de acesso a dados da aplicação

###### services
pacote que isola a regra de negocio para tratamento dos dados

###### util
pacote para uso de refatoração durante a identificação de metodos que podem ser aproveitados por outras entidades

