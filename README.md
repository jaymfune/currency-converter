# Currency Converter

Currency Converter is a Java application that allows users to convert an amount from one currency to another based on the latest exchange rates obtained from a public API. The application uses the Free Currency API to fetch the exchange rates.

## Prerequisites

To run this application, you need to have the following software installed on your system:

- Java Development Kit (JDK) 17 or higher
- Apache Maven

## Getting Started

Follow the steps below to set up and run the Currency Converter application:

1. Clone the repository:

```bash
git clone https://github.com/your-username/currency-converter.git
```

2. Change into the project directory:

```bash
cd currency-converter
```

3. Build the project using Maven:

```bash
mvn package
```

This will compile the Java source code, download the required dependencies, and package the application into an executable JAR file named `currency_converter-1.0-SNAPSHOT-jar-with-dependencies.jar` with all dependencies included.

## How to Use

To run the Currency Converter application:

### Run the Executable JAR

Run the application using the generated executable JAR with dependencies included. Execute the following command:

```bash
java -jar target/currency_converter-1.0-SNAPSHOT-jar-with-dependencies.jar
```

Follow the prompts to input the base currency, target currency, and the amount you want to convert. The application will display the converted amount.

Again, follow the prompts to input the required details and get the converted amount.

## Supported Currencies

The application currently supports the following currencies for conversion:

- ZAR (South African Rand)
- USD (United States Dollar)
- EUR (Euro)
- CAD (Canadian Dollar)

## API Key

Please note that the application uses a free API key to access the Free Currency API. If you encounter any issues with the API or want to use it extensively, you might need to acquire your own API key from the Free Currency API website.

## Troubleshooting

- If you encounter any issues while running the application, ensure that you have the correct Java version and Apache Maven installed on your system.
- Double-check the input for base currency and target currency. Ensure they are valid currency codes (e.g., "USD", "EUR", "ZAR", "CAD").
- If the application fails to fetch exchange rate data, verify your internet connection and check if the Free Currency API is operational.

## Contributions

Contributions to this Currency Converter project are welcome! Feel free to open issues, suggest improvements, or create pull requests.

## License

This Currency Converter application is open-source and licensed under the MIT License. Feel free to use, modify, and distribute it in accordance with the terms of the MIT License.

## Contact

For any questions or inquiries about the Currency Converter application, you can contact [jacobmfune2@gmail.com](mailto:jacobmfune2@gmail.com).

Happy currency converting! 🚀
