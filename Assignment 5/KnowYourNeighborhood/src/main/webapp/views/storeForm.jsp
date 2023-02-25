<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8" />
      <title>Add Store</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
    </head>

    <body style="display: flex; justify-content: center">
      <!-- Card -->
      <div class="card mt-5 px-5">
        <div class="card-body">
          <h1>Add New Store</h1>
          <!-- Form -->
          <form:form modelAttribute="store" action="save" method="post">

            <form:label for="name" path="name">Store Name :</form:label>
            <form:input type="text" class="form-control mb-3" name="name" path="name" value="${name}" />


            <form:label for="phone_number" path="phone_number">Phone Number :</form:label>
            <form:input type="text" class="form-control mb-3" name="phone_number" path="phone_number"
              value="${phone_number}" />


            <form:label for="localities" path="localities">Location :</form:label>
            <form:input type="text" class="form-control mb-3" name="localities" path="localities"
              value="${localities}" />


            <form:hidden path="id_store" value="${id_store}" />
            <form:button type="submit" class="btn btn-success">Submit</form:button>
          </form:form>
        </div>
      </div>
    </body>

    </html>