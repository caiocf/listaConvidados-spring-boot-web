"# listaConvidados-spring-boot-web" 
Projeto construido utilizando o framework spring-boot-web.

Consiste em pagina web de cadastro de convidados que possibilizar fazer o cadastro e remoção do convidado.
O Banco de dados utilizado foi Mysql.

Ferramentas:
spring-boot-starter-actuator: Para monitoramente da saúde da aplicação.
spring-boot-starter-thymeleaf: Engine de templetes do spring de paginas html.
spring-boot-starter-data-jpa: Mapemanto de Pojos especificação JPA com a implementação Hibernate
spring-boot-devtools: Ferramenta para hotDeploy automatico (sendo necessario instalar um plugin "LiveReload " nos browsers se visualizar a troca do html)
commons-email: Biblioteca para envio de email.
rpm-maven-plugin: Pluguin utilizado para gerar um pacote RPM para se instalar em distro baseadas em rpm. 
     Comando: # mvn rpm:rpm