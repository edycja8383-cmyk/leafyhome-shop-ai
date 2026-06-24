# 🌿 AI Recommendation System - Lux Garden Shop

An interactive console application written in Java that simulates an intelligent customer assistant for a gardening store. The project leverages the **LangChain4j** framework and the **Llama 3.3** model (via **Groq API**) to dynamically respond to customer inquiries based on real-time stock levels and a personalized pricing engine.

## ✨ Main Features
* **Interactive Chatbot:** Customers can type their plant-related problems directly into the console and receive real-time advice.
* **LLM Integration (Groq/Llama 3.3):** The system connects to an advanced language model to generate natural, friendly, and marketing-oriented responses.
* **Dynamic Pricing Engine (`PricingEngine`):** The AI factors in dynamic product prices and warehouse stock levels when making recommendations.
* **Product Database Management:** The application handles real data (fertilizers, soil, pots) and automatically adapts to stock shortages or surpluses.

## 🛠️ Tech Stack
* **Java** (Version 17+)
* **Maven** (Dependency management)
* **LangChain4j** (AI model integration)
* **Groq API / Llama 3.3**

## 🚀 How to Run the Project

1. Clone the repository:
   ```bash
   git clone [https://github.com/YourGitHubUsername/leafyhome-shop-ai.git](https://github.com/YourGitHubUsername/leafyhome-shop-ai.git)
2. Configure your Groq API key in your environment variables or directly within the model configuration code.

3. Run the ShopApp.java class in your IDE (e.g., IntelliJ IDEA).

4. Type your gardening problem into the console and chat with your AI Green Advisor!

_Just remember to change **YourGitHubUsername** to your actual GitHub username before committing. Once you add this, just Commit and Push, and your documentation will be complete and fully professional!_

## 🗺️ Future Improvements (To-Do)

Here are the next simple steps planned to improve and expand this application:

### 1. Data Management & Validation
* **Load Products from File:** Instead of hardcoding products in Java, load the store inventory dynamically from a simple `.txt` or `.csv` file.
* **Input Validation:** Add secure checks to prevent the application from crashing if a user inputs empty text or incorrect characters.
* **Save Chat History:** Export the entire conversation with the AI advisor to a local log file (`chat_history.txt`) at the end of the session.

### 2. Business & Logic Expansion
* **Basic Discount Codes:** Update the `PricingEngine` to allow users to type a promo code (e.g., `SUMMER10`) to get a 10% discount on their total order.
* **Low Stock Alerts:** Add a simple mechanism that highlights or flags products in the console when their stock level drops below 3 items.

### 3. Quality & Code Cleanliness
* **Unit Tests:** Write basic JUnit tests for the `PricingEngine` to ensure that discounts and stock checks calculate perfectly every time.
* **Interactive Menu:** Replace the continuous text prompt with a simple numbered console menu (e.g., `1. Ask Advisor, 2. View Stock, 3. Exit`).
