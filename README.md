# Health-O-Meter
Original web-based healthcare application intended to collect and categorize user health data, providing support in healthcare related aspects for life quality improvement.

# General project overview:
- Collection of user’s basic health related information (such as blood group, weight, height)
- Body fat percentage calculation performed according to the chosen methodology (body mass index (BMI), hips-to-waist ratio (HTW), body adiposity index (BAI) or waist circumference measurement (WCM)). 
- Notifications for incoming medical appointments, healthcare related events, free of charge preventive medical examination opportunities
- Data visualization based on recent user inputs, such as blood pressure and/or medical appointment.

# Technology stack and tools:
**Back-End:**
* Database during deployment: PostgreSQL
* Programming language: Java 11
* Build automation tool: Maven
* Database during production: H2
* Framework: Spring
* Test coverage - target 75%

**Front-End:** [Go to see the Front-End repository](https://github.com/WiolettaL/Health-O-Meter-Front)
* UI Library: React
* Tests: React Testing Library
* JavaScript(ES6+), SCSS, npm
* Design system: Material UI
* (server for Heroku: Node.js, express.js)
* Test coverage - target 75%

**Tools:**
* Version control system: GIT
* SonarCloud for code quality
* CircleCi
* Figma
* Slack
* Miro
* Jira