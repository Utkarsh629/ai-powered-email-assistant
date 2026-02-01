# 🚀 AI-Powered Email Assistant  
### Gmail Chrome Extension | Spring Boot | Large Language Model (LLM)

> **Automates professional email replies directly inside Gmail using an AI-powered Chrome Extension backed by a Spring Boot REST API and an LLM.**

---

## 📌 Project Overview

The **AI-Powered Email Assistant** is a full-stack AI application that integrates seamlessly into Gmail to generate high-quality, professional email replies in real time.

This project demonstrates **end-to-end system design**, combining browser extension development, backend API engineering, and controlled LLM prompt execution to deliver a production-oriented user experience.

---

## 🧠 Key Features

- ✉️ **AI Reply button** injected directly into Gmail’s compose window  
- 🤖 **LLM-powered email generation** with strict prompt control (single, complete response)  
- ⚡ **Real-time communication** between Chrome Extension and backend REST API  
- 🔍 **MutationObserver-based DOM handling** for Gmail’s dynamically rendered UI  
- 🔐 **Secure API key management** using environment variables  
- 🧩 **Modular architecture** with clear separation between extension, frontend, and backend  

---

## 🏗️ System Architecture

```text
ai-powered-email-assistant
├── email-writer-ext        # Chrome Extension (Gmail UI integration)
├── email-writer-frontend  # React application (standalone email generator)
└── email-writer-sb        # Spring Boot backend (LLM integration)
🔄 Architecture Flow
User opens Gmail compose window

Chrome Extension injects AI Reply button using DOM observation

Email content is extracted from Gmail UI

Request is sent to Spring Boot REST API

Backend constructs a controlled prompt and calls the LLM

Generated response is returned and inserted into the compose box

🛠️ Tech Stack
Frontend / Extension
JavaScript (ES6+)

Chrome Extension APIs (Manifest V3)

DOM Manipulation

MutationObserver

Backend
Java

Spring Boot

RESTful APIs

WebClient

AI / LLM
Prompt Engineering

Gemini API (LLM integration)

Output constraint enforcement

Tooling & Practices
Git & GitHub

Environment Variables for secrets

Modular, production-oriented architecture

🔐 Security & Configuration
API keys are never hardcoded

Sensitive values are injected using environment variables

Backend configuration isolated via application.properties

.gitignore prevents secrets and build artifacts from being committed

🎯 Engineering Highlights
Designed prompt constraints to prevent multi-response or verbose LLM output

Handled Gmail’s non-static DOM structure using MutationObserver

Built a clean REST API boundary between UI and AI logic

Applied separation of concerns across extension, frontend, and backend layers

📈 Why This Project Matters
This project reflects real-world AI engineering challenges, including:

Integrating AI into existing platforms (Gmail)

Managing unreliable DOM structures

Enforcing deterministic LLM behavior

Securing production credentials

Designing scalable, modular systems

📎 Repository Structure
Each component can be run and tested independently:

Chrome Extension → Gmail integration

React Frontend → Standalone email generation

Spring Boot API → AI orchestration layer

🧪 Future Enhancements
Tone selection via UI

Reply preview and edit mode

Authentication and usage limits

Model switching support

Deployment using Docker

👤 Author
Utkarsh Raj
Computer Science Engineer | Backend & AI Enthusiast

