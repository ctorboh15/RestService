<%@include file="../includes/globalTagLibs.jsp" %>
 <script type="text/javascript" src="/resources/js/customer.js"></script>
<table>
        <form method="POST" action="/rest/customers" id="editCustomerForm">
            <input type="hidden" value="${customer.id}" name="id"/>
            <tr>
                <td>First Name</td>
                <td><input type="textbox" name="firstName" value="${customer.firstName}"/> </td>
            </tr>
            <tr>
                <td>Last Name</td>
                 <td><input type="textbox" name="lastName" value="${customer.lastName}"/> </td>
            </tr>
            <tr>
                <td>Email</td>
                 <td><input type="textbox" name="email" value="${customer.email}"/> </td>
            </tr>
            <tr>
                <td>Contact Number</td>
                 <td><input type="textbox" name="mobile" value="${customer.mobile}"/> </td>
            </tr>
            <tr>
                <td>D.O.B</td>
                 <td><input type="textbox" name="dateOfBirth" value="${customer.dateOfBirth}"/> </td>
                <td>${customer.dateOfBirth}</td>
            </tr>
           </form>
       </table>