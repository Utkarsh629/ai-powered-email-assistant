# 🚀 AI-Powered Email Assistant (Gmail Chrome Extension)

An end-to-end **AI-powered email reply system** that integrates directly into **Gmail** using a **Chrome Extension**, a **Spring Boot REST API**, and a **Large Language Model (LLM)** to generate **professional email responses in real time**.

This project demonstrates **full-stack engineering**, **browser extension development**, and **LLM integration** with a production-oriented architecture.

---

## 📌 Project Summary

The AI-Powered Email Assistant automates professional email replies directly inside Gmail.

It combines:
- Frontend **DOM manipulation**
- Backend **REST API engineering**
- Controlled **LLM prompt design**

to deliver a seamless, real-world user experience.

The system is designed with:
- Clean separation of concerns  
- Secure configuration management  
- Scalable, modular architecture  

---

## 🧠 Core Features

- ✉️ **AI Reply button injected into Gmail compose window**
- 🤖 **Single, high-quality professional email reply generation**
- ⚡ **Real-time communication** between Chrome Extension and backend API
- 🔍 **Dynamic DOM handling** using `MutationObserver` for Gmail’s changing UI
- 🔐 **Secure API key handling** via environment variables
- 🧩 **Modular architecture** with independent extension, frontend, and backend layers

---

## 🏗️ System Architecture

### 📦 Project Structure

```text
ai-powered-email-assistant
├── email-writer-ext        # Chrome Extension (Gmail UI integration)
├── email-writer-frontend  # React application (standalone email generator)
└── email-writer-sb        # Spring Boot backend (LLM integration)




🔄 Architecture Flow

User opens the Gmail compose window

Chrome Extension detects UI changes using MutationObserver

AI Reply button is injected into the Gmail toolbar

Email content is extracted from the Gmail DOM

A request is sent to the Spring Boot REST API

Backend constructs a controlled prompt and calls the LLM

Generated response is returned and inserted into the compose box

🛠️ Tech Stack
🌐 Frontend / Chrome Extension

JavaScript (ES6+)

Chrome Extension APIs (Manifest V3)

DOM Manipulation

MutationObserver

⚙️ Backend

Java

Spring Boot

RESTful APIs

WebClient (external API calls)

Environment-based configuration

🤖 AI / LLM

Large Language Model (LLM) integration

Prompt engineering for controlled outputs

Single-response enforcement (no suggestions or explanations)

🔐 Configuration & Security

Sensitive credentials are never hardcoded.

The backend uses environment variables:

GEMINI_API_URL=your_api_url_here
GEMINI_API_KEY=your_api_key_here


These are injected via application.properties using Spring’s configuration system.

▶️ How It Works (High Level)

The Chrome Extension handles Gmail UI interaction

The Spring Boot backend manages prompt construction and LLM communication

The LLM generates a clean, professional email reply

The reply is inserted directly into Gmail with one click

🎯 Why This Project Matters

This project demonstrates:

Real-world full-stack development

Practical AI integration (not just API calls)

Browser extension engineering

Clean system design and production-ready practices

It reflects skills expected in:
Software Engineer · Full-Stack Engineer · Backend Engineer · AI Engineer roles.

🚀 Future Enhancements

Tone selection UI inside Gmail

Reply history & regeneration

User authentication

Dockerized deployment

Rate limiting & caching

👤 Author

Utkarsh Raj
GitHub: https://github.com/Utkarsh629
