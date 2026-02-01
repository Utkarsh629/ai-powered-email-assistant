🚀 AI-Powered Email Assistant (Gmail Chrome Extension)

An end-to-end AI-powered email reply system that integrates directly into Gmail using a Chrome Extension, a Spring Boot REST API, and a Large Language Model (LLM) to generate professional email responses in real time.

📌 Project Summary

This project demonstrates the design and implementation of a full-stack AI application that automates professional email replies directly inside Gmail.
It combines browser extension development, backend API engineering, and LLM prompt control to deliver a seamless user experience.

The system is built with a production-oriented architecture, secure configuration management, and clean separation of concerns.

🧠 Core Features

📧 AI Reply button injected into Gmail compose window

🤖 Automatic generation of single, high-quality professional email replies

⚡ Real-time interaction between Chrome Extension and backend API

🔍 DOM manipulation using MutationObserver for Gmail’s dynamic UI

🔐 Secure handling of API keys using environment variables

🧩 Modular architecture with independent frontend, backend, and extension layers

🏗️ System Architecture
ai-powered-email-assistant
│
├── email-writer-ext        # Chrome Extension (Gmail UI integration)
├── email-writer-frontend   # React application (standalone email generator)
└── email-writer-sb         # Spring Boot backend (LLM integration)

Architecture Flow

User clicks “AI Reply” inside Gmail

Chrome Extension extracts the email content from the DOM

Request is sent to a Spring Boot REST API

Backend constructs a constrained prompt and calls the LLM (Gemini API)

Generated reply is returned and injected back into Gmail’s compose editor

🛠️ Tech Stack (ATS-Optimized)
Backend

Java

Spring Boot

RESTful APIs

Spring WebFlux (WebClient)

Jackson (JSON parsing)

Environment-based configuration management

Frontend

React

Material UI

Axios

Chrome Extension

JavaScript

DOM manipulation

MutationObserver

Gmail UI integration

Chrome Extension APIs (Manifest v3)

AI / NLP

Large Language Model (LLM)

Prompt Engineering

Gemini API integration

🔐 Security & Best Practices

No secrets committed to source control

API keys injected via environment variables:

gemini.api.url=${GEMINI_API_URL}
gemini.api.key=${GEMINI_API_KEY}


.gitignore configured to exclude:

API keys

Build artifacts

Node modules

OS/editor files

⚙️ Setup Instructions
Backend (Spring Boot)
export GEMINI_API_URL=https://generativelanguage.googleapis.com
export GEMINI_API_KEY=your_api_key_here
./mvnw spring-boot:run

Frontend (React)
cd email-writer-frontend
npm install
npm run dev

Chrome Extension

Open chrome://extensions

Enable Developer Mode

Click Load unpacked

Select the email-writer-ext directory

Open Gmail and start composing an email

🎯 Engineering Decisions

Prompt constraint enforcement: Ensures the LLM returns only one final email reply (no explanations or multiple options)

Backend abstraction of LLM logic: Keeps API keys secure and allows future model changes

MutationObserver usage: Handles Gmail’s dynamically rendered UI reliably

Monorepo structure: Simplifies development, testing, and deployment

🚧 Potential Enhancements

Tone selection within Gmail UI

Response streaming for improved UX

User authentication and rate limiting

Support for additional email platforms (Outlook, Yahoo)

👨‍💻 Author

Utkarsh Raj
Computer Science Engineering
Interests: Backend Development, Cloud Computing, Applied AI Systems

⭐ Why this project stands out

This project demonstrates:

Real-world Chrome Extension development

Secure Spring Boot REST API design

Practical LLM integration with prompt control

Full-stack system thinking

Production-ready coding practices

📌 Resume-Ready Keywords (Intentional)

Spring Boot · REST API · Chrome Extension · Java · React · LLM · Prompt Engineering · Web APIs · Backend Development · Full-Stack · API Security · System Design
