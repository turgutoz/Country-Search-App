App Name: Country Search App

Author: Turgut Can Ozdemir

E-mail: turgutcanozdemir@gmail.com

Release Date: 02/2023

If you have any questions or suggestions, please contact.

GENERAL INFO:

- The application was built using knowledge and libraries obtained from the 'Android Applications with Kotlin & Java' course offered by the 'C and Systems Programmers Association' and taught by Oguz Karan.

- The application uses the 'GeoNames countryInfo WebService' API.

FEATURES:

- You can retrieve information such as country name, capital, continent, languages, population, and currency by using global country codes (e.g. US, DE, FR, TR).

- The application automatically creates Wikipedia links on the Country Details Activities.

- Although Geonames returns 18 features of countries, CountrySearchApp presents 6 features and a link to reduce complexity.

- The application uses DataBinding for most of the UI elements.

- It was designed by adhering to layered architecture (repository, API, service, application).

- Dependency Injection (Hilt) was used.

- When the 'Show Country Information' button is pressed for the first time, the app asks if you want to save the country information to the database. If your answer is 'Yes' and it has not been saved before, it saves it to the local database. When the button is pressed again, it pulls the recorded data from the database. This method provides protection from the cost if there is any usage quota or cost in using the API.

WEAKNESSES:

- Performance could be improved by providing a solution with one DetailsActivity instead of two DetailsActivities. Due to the instantiation of the Country List given to the ListView, two separate activities were created. This approach can be changed and improved.

- Since the focus of the application is on the backend code, less attention was paid to the UI/UX design.
