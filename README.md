<h1 align="center"><a id="user-content---sobre-o-projeto-" class="anchor" aria-hidden="true" href="#--sobre-o-projeto-"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a> <g-emoji class="g-emoji" alias="computer" fallback-src="https://github.githubassets.com/images/icons/emoji/unicode/1f4bb.png">🎯</g-emoji> Sobre o Projeto </h1>

### <i>Este projeto  pessoal , representa um sistema de Ponto eletrônico utilizando da Arquitetura de Microserviços orientada a eventos simultaneamente com arquitetura Hexagonal.
Foram utilizados soluções de consumo e publicação de mensagens em broker de eventos utilizando de Mensageria como Kafka e RabbitMQ.


## 🛠 Tecnologias utilizadas

### 🧱 Back end

- Java 11
- Spring Boot
- JavaMail
- Apache Kafka
- RabbitMQ
- ModelMapper
- Lombok
- Gson
- Redis
- PostgreSQL
- MongoDB
- Maven
- Docker
 

 
## Endpoints 
 
 Observações :
 
 1-Ainda não foi implementado validações de campo.
 
 2-Informe um email válido pois será enviado uma notificação para o mesmo.
 
 3-É necessário alterar as informações do envio de email no <code>application.properties</code> do microsserviço **Email** para o seu email ( Apartir dele  que vai ser feito o envio), além disso vai ser necessário gerar uma <code>key</code> referente ao email informado e coloca-lo no campo <code>spring.mail.password</code> , isso é necessário pois vamos utilizar o protocolo SMTP.Segue o link com o passo a passo para gerar essa senha :
 
 https://support.google.com/accounts/answer/185833
 
 4-Na classe **NotificationConsumer** do microsserviço **Email**, é necessário alterar o nome do email que foi setado na variável <code>emailDomain</code> para o seu email do item 3.
 
 
 - Cadastrar Usuario ( Post )
 
 <code>http://localhost:8081/auth/signup</code>
 
 exemplo de body :
 
         {
        "firstName":"Fulano",
        "lastName":"Silva",
        "email":"seuemailvalido@gmail.com",
        "departmentType":"TECHNOLOGY_DEPARTMENT"
        }
 
- Registrar um ponto eletronico  ( Post )
 
 <code>http://localhost:8082/attendances/{userId}/attend</code>

## Veja a seguir como foi feita a Arquitetura Hexagonal dos Microsserviços :

### User Microservice :


![User-Hexagonal-Architecture](https://user-images.githubusercontent.com/60756219/152538711-144abc5c-5665-4d93-a7ee-dcaa4234ba53.png)



### Attendance Microservice :


![Attendance-Hexagonal-Architecture](https://user-images.githubusercontent.com/60756219/152538961-2899cc27-9579-428d-8087-5f8bb98a48cf.png)



### Notification Microservice :


![not](https://user-images.githubusercontent.com/60756219/152558567-1e3cb912-cd82-4b7d-a103-60f6077d9c8b.png)



### Email Microservice :
 
 ![em](https://user-images.githubusercontent.com/60756219/152559659-0564f77c-094c-4a21-becd-64c6e169f005.png)





 #
      
<p align="center">Made with <g-emoji class="g-emoji" alias="green_heart" fallback-src="https://github.githubassets.com/images/icons/emoji/unicode/1f49a.png">💚</g-emoji> by Bruno Pinho</p>
      
 #
