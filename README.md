App Name: Country Search App 

Author: Turgut Can Ozdemir

E-mail: turgutcanozdemir@gmail.com

Date: 02/2023

If you have any questions or suggestions, please contact.

GENERAL INFO:

- The application was built using knowledge from the ‘Android Applications with Kotlin & Java’ education provided by the ‘C and Systems Programmers Association’

- The application uses ‘GeoNames countryInfo WebService’ as API

FEATURES:

- You can get some information like country name, capital, continent, languages, population, currency by using global country codes (e.g. US, DE, FR, TR)

- Application creates Wikipedia Links automatically on the Country Details Activities

- Although Geonames returns 18 features of countries, CountrySearchApp presents 6 feature and a link to reduce complexity

- Application uses DataBinding mostly

- Designed by adhering to layered architecture (repository, api, service, application)

- Dependency Injection (Hilt)

- When the ‘Show Country Information’ button is pressed for the first time, the app asks if you want to save the country information to the database. If your answer is ‘Yes’ and it is not saved before, it saves it to the local database. When the next time button is pressed, it pulls the recorded data from the database. Thus, if there is any usage quota or cost in using the API, this method provides protection from the cost.

WEAKNESS:

- Performance could be improved by providing a solution with one DetailsActivity instead of two DetailsActivitiys. Due to the instantiation of the Country List given to the ListView, two separate activities were made. This approach can be changed and improved

- Since the purpose is the backend codes of the application, it is not focused on the UI / UX
