Banking Assistant --- Microservices & AI Chatbot
An academic project built with Spring Boot and Spring Cloud,
demonstrating a microservices-based banking system with an AI-powered
conversational assistant, an LLM integration, and access through a web
interface and Telegram.

Overview
This project demonstrates the design of a distributed banking
application composed of independent microservices. Spring Cloud provides
service discovery and centralized configuration, while an API gateway
acts as the main entry point for incoming requests.

The chatbot service connects to a Large Language Model (LLM) to
interpret user questions and generate responses. The Model Context
Protocol (MCP) integration shown in the architecture allows the AI
agent to interact with compatible business services and tools. Telegram
provides an additional channel for communicating with the assistant.
Architecture

![Capture d'![Capture d'écran 2026-10-21 220714.png](bank-chatBot/src/main/resources/img/Capture%20d%27%C3%A9cran%202026-10-21%20220714.png)écran 2026-10-21 220714.png](../../Pictures/Screenshots/Capture%20d%27%C3%A9cran%202026-10-21%20220714.png)

Main components
Component                           Responsibility
Angular Web Interface           User interface for viewing data and
interacting with the application.

Spring Cloud Gateway / Zuul     Entry point for incoming requests
and routing to the appropriate
services. The final choice depends
on the actual implementation.

Discovery Service               Registers services and enables
service discovery.

Spring Cloud Config Service     Centralizes configuration for
microservices.

Ebank Service                   Banking business service, including
access to data and operations
exposed by the application.

Customer Service                Handles customer-related
functionality.

Ebank Chatbot Service           Orchestrates conversations and
coordinates requests between the
LLM and business services.

LLM                             Language model used to interpret
questions and generate responses.

MCP Streamable                  Integration mechanism through which
the agent can access tools or
business services compatible with
MCP.

Telegram API                    Messaging channel for sending
requests to the chatbot and
receiving responses.
Note: The diagram represents the target architecture. Adapt the
component names and integrations to the current state of the
repository. In particular, Zuul and Spring Cloud Gateway are separate
technologies; document the one actually used in the codebase.

Planned features
- Microservices-based architecture.
- Centralized request routing through an API gateway.
- Service discovery and centralized configuration.
- Banking functionality exposed through dedicated services.
- Conversational assistant connected to an LLM.
- Business-tool integration through MCP Streamable.
- Access to the assistant through a web interface and Telegram.
  Technology stack
  Technologies represented in the architecture include:
- Backend: Java, Spring Boot, Spring Cloud
- API Gateway: Spring Cloud Gateway or Zuul
- Frontend: Angular
- Conversational AI: LLM
- Tool interoperability: Model Context Protocol (MCP)
- Messaging: Telegram Bot API
  Exact versions and dependencies should be documented based on the
  project files, such as pom.xml, package.json, configuration files,
  and environment variables.
  Suggested repository structure
  The actual structure depends on the repository. One possible
  organization is:

  Rename these directories to match the actual folders in your repository.
  Prerequisites
  Before running the project, check the requirements for your
  implementation:
- A JDK compatible with the Spring Boot version used.
- Maven or Gradle, depending on the build tool.
- Node.js and npm for the Angular frontend.
- Any required external services, such as an LLM provider or local LLM
  server, a database, and the Telegram Bot API.
- Required environment variables and configuration files.
  Installation and running
  The exact commands depend on the module names and configuration. For a
  Spring Boot Maven module, the usual command is:
# Run from the relevant module directory
./mvnw spring-boot:run
On Windows, use:
.\mvnw.cmd spring-boot:run
To run Angular:
cd frontend
npm install
npm start
Start infrastructure dependencies and microservices in the order
required by your configuration, then start the frontend. Check
application.yml, application.properties, pom.xml, and
package.json for ports, profiles, and required settings.
Configuration
Store sensitive settings in environment variables or an appropriate
configuration mechanism. For example:
