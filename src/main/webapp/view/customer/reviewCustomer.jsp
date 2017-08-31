<%@include file="../includes/header.jsp" %>
<div class="container">
        <h3>Welcome, Review Customer Details</h3>
         <table>
            <input type="hidden" value="${customer.id}" name="id"/>
            <tr>
                <td>First Name</td>
                <td>${customer.firstName}</td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td>${customer.lastName}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${customer.email}</td>
            </tr>
            <tr>
                <td>Contact Number</td>
                <td>${customer.mobile}</td>
            </tr>
            <tr>
                <td>D.O.B</td>
                <td>${customer.dateOfBirth}</td>
            </tr>
             <tr>
                <td><input type="button" id="editCustomer" value="Edit" onclick="openModalPopup('/customer/edit/${customer.id}')"></td>
                <td><a href="/customer/create"><input type="button" value="Cancel"></a></td>
            </tr>
       </table>


  <h2>Modal Example</h2>
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>



</div>

<%@include file="../includes/footer.jsp" %>
