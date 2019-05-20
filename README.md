# PandoraBot-Telegram
Pandorabot AIML 1.0 Platform interface for the Telegram Bot API.

# Build requirements
* Gradle
* JDK 8

# Setup Pandorabot
* Create an account on https://www.pandorabots.com/botmaster/en/home
* Create a Pandorabot with one of the existing AIML knowledge
* Copy the 16-character bot id.

# Setup Telegrambot
 Talk to @BotFather on Telegram to create a bot and receive the bot token.

 # Setup bot properties
 Edit the `bot.properties` file in the resources directory to include your Telegram bot username, token and Pandorabot id.
# Build project
```
git clone https://github.com/philipinho/pandorabot-telegram.git
$ cd pandorabot-telegram
$ gradle build
```

# Running the bot
```$ java -jar build/libs/pandorabot-telegram-1.0-SNAPSHOT.jar```

To run bot continuously after closing the session use `nohup`

```$ nohup java -jar build/libs/pandorabot-telegram-1.0-SNAPSHOT.jar &```