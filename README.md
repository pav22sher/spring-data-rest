### Spring Data Rest methods mapping
* GET /companies?page=1&size=1&sort=name,desc -> findAll
* POST /companies -> save
* GET /companies/{id} -> findById(id)
* PUT /companies/{id} -> save()
* PATCH /companies/{id} -> save()
* DELETE /companies/{id} -> deleteById(id)
* GET /companies/search/{customMethod}?{param}={value} -> customMethod()
* queryDsl GET /companies?inn=1234567890

@RepositoryRestResource - class
@RestResource - method
