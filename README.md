# Research Paper Collector

一个科研论文收集与智能分析系统，旨在自动化管理论文信息、提取关键词、生成摘要，并为科研人员提供便捷的论文管理与搜索服务。

---

## 🏗️ 项目结构

```
research-paper-collector/
├── ai-service/         # 负责论文内容分析、关键词提取、摘要整理等AI功能
│   ├── src/
│   ├── pom.xml
│   └── ...
│
├── paper-service/      # 负责论文数据管理与检索，提供论文信息接口
│   ├── src/
│   ├── pom.xml
│   └── ...
│
└── README.md           # 项目说明文件
```

---

## ⚙️ 技术栈

* **后端框架**：Spring Boot
* **语言**：Java 17
* **构建工具**：Maven
* **数据库**：MySQL
* **AI 模块**：关键词提取、摘要生成
* **接口通信**：HTTP

---

## 🚀 启动步骤

1. **克隆项目**

   ```bash
   git clone https://github.com/yuanlang1/research-paper-collector.git
   cd research-paper-collector
   ```

2. **进入子服务目录并启动**

    * 启动论文管理服务：

      ```bash
      cd paper-service
      mvn spring-boot:run
      ```

    * 启动 AI 服务：

      ```bash
      cd ai-service
      mvn spring-boot:run
      ```

3. **访问服务**

    * Paper Service: [http://localhost:8080](http://localhost:8080)
    * AI Service: [http://localhost:8081](http://localhost:8081)

---

## 📦 服务说明

### paper-service

* 接收论文检索请求，任务请求
* 保存论文元信息（标题、作者、年份、摘要、关键词等）
* 向 `ai-service` 发起分析请求

### ai-service

* 提取论文关键词
* 生成论文摘要
* 返回结构化的分析结果

---

## 👨‍💻 作者

**Yuan Lang**

GitHub: [@yuanlang1](https://github.com/yuanlang1)

---
