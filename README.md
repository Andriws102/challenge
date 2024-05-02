# Technology

- Project developed with Java21 and Spring boot 3.2.5.
- Database MySQL.
- Liquibase was chosen to manage changes in database.
- For Observability was used the spring boot extension spring-boot-starter-aop and spring-boot-starter-actuator.
- For Caching was used the spring boot extension spring-boot-starter-cache.

# Setup
 Follow the next steps for setting up the project:
1. Create in mysql the database with name challenge or must change the name of the database in 
application.properties in the line number 9.
2. Set up the username for logging in the database in application.properties in the line number 11.
3. Set up the password for logging in the database in application.properties in the line number 12.
4. Compile the project with java 21 after loaded the gradle dependencies.
5. Liquibase going to create the database and execute inserts of test data, if you don't need
test data comment or delete the lines 23 to 30 in the file liquibase-changelog.xml, you can find the MER in the folder additionalnfo.
6. After deploy you can import the postman.collections in the folder additionalnfo for test the different endpoints.

# Endpoints

## Books
Root path "/books" all endpoints has the next params optionals.

alldata (boolean): 
[true] get additional information of the books like Reviews, Authors and Copies of the books.
[false] only get the basic info.

onlyavailable (boolean): **REQUIRE PARAM alldata IN TRUE.**
[true] get books copies with status 1 (Available).
[false] get all books copies.

1. Get book by id: path="/{id}" verb=GET
2. Get books by Author name: path="/getByAuthor" verb= GET additional_params= authorname (is only the first name).
3. Get books by partial title: path="/getByTitle" verb=GET additional_params= title (can be a partial title and is case sensitive).

## Reviews
Root path "/reviews"

1. Get review by id: path="/{id}" verb=GET
2. Get reviews by book id: path="/getByBook/{bookId}" verb=GET
3. Get reviews by user id: path="/getByUser/{userId}" verb=GET
4. Create review: path="/" verb=POST needs the next body in JSON format
```json   
   {
   "bookId": [Id of the book],
   "userId": [Id the user],
   "comment": [Comment of the book is optional],
   "rate": [Rate with a number the book]
   }
```

## Reservation
Root path "/reservations"

1. Get reservation by id: path="/{id}" verb=GET
2. Create reservation: path="/" verb=POST needs the next body in JSON format
```json
{
    "bookCopyId": [Book copy id],
    "userId": [Id user],
    "bookingUntil": [Limit reservation date],
    "bookingSince": [Since reservation date]
}
```
3. Process reservation and set the book copy as lent: path="/processReservation/{reservationId}" verb=PATCH
4. Finish reservation and set the book copy as Available: path="/finishReservation/{reservationId}" verb=PATCH
5. Cancel reservation and set the book copy as Available: path="/cancelReservation/{reservationId}" verb=PATCH

# STATUS_IDS

## Books Copies

- 0: Unavailable
- 1: Available
- 2: Rent
- 3: Reserverd


## Reservation

- 0: Register
- 1: Process
- 2: Finished
- 3: Canceled
- 4: Accept without process


# METRICS

All endpoints are monitoring you can find the metrics in the path "/actuator/metrics".

## Paths for endpoint:

1. Get book by id = "/actuator/metrics/GetBookByIdImpl".
2. Get book by author = "/actuator/metrics/GetBookByAuthorImpl".
3. Get book by title = "/actuator/metrics/GetBookByTitleImpl".
4. Get review by id = "/actuator/metrics/GetReviewByIdImpl".
5. Get reviews by book = "/actuator/metrics/GetReviewByBookIdImpl".
6. Get reviews by user = "/actuator/metrics/GetReviewByUserIdImpl".
7. Create review = "/actuator/metrics/CreateReviewImpl".
8. Get reservation by id = "/actuator/metrics/GetBookingByIdImpl".
9. Create reservation = "/actuator/metrics/CreateBookingImpl".
10. Process reservation = "/actuator/metrics/UpdateStatusBookCopyImpl".
11. Finish reservation = "/actuator/metrics/UpdateStatusBookCopyImpl".
12. Cancel reservation = "/actuator/metrics/UpdateStatusBookCopyImpl".

## What show the metrics?

In the metrics we can find measurements like execution quantities, total execution time, and max execution time.

Additionally we can find the different methods and the errors thrown in executions.
Example:
```json
{
    "name": "GetBookingByIdImpl",
    "baseUnit": "seconds",
    "measurements": [
        {
            "statistic": "COUNT",
            "value": 1.0
        },
        {
            "statistic": "TOTAL_TIME",
            "value": 0.1759582
        },
        {
            "statistic": "MAX",
            "value": 0.0
        }
    ],
    "availableTags": [
        {
            "tag": "method",
            "values": [
                "apply"
            ]
        },
        {
            "tag": "error",
            "values": [
                "none"
            ]
        },
        {
            "tag": "class",
            "values": [
                "com.javaexercise.challenge.services.impl.GetBookingByIdImpl"
            ]
        }
    ]
}
```