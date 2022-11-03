<%--
  Created by IntelliJ IDEA.
  User: MrBhite
  Date: 2022/11/4
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<h3>Account Information</h3>
<table>
  <tr>
    <td>First name:</td>
    <td><input type="text" name="account.firstName"></td>
  </tr>
  <tr>
    <td>Last name:</td>
    <td><input type="text" name="account.lastName"></td>
  </tr>
  <tr>
    <td>Email:</td>
    <td><input type="text" name="account.email"></td>
  </tr>
  <tr>
    <td>Phone:</td>
    <td><input type="text" name="account.phone"></td>
  </tr>
  <tr>
    <td>Address 1:</td>
    <td><input type="text" name="account.address1"></td>
  </tr>
  <tr>
    <td>Address 2:</td>
    <td><input type="text" name="account.address2"></td>
  </tr>
  <tr>
    <td>City:</td>
    <td><input type="text" name="account.city"></td>
  </tr>
  <tr>
    <td>State:</td>
    <td><input type="text" name="account.state"></td>
  </tr>
  <tr>
    <td>Zip:</td>
    <td><input type="text" name="account.zip"></td>
  </tr>
  <tr>
    <td>Country:</td>
    <td><input type="text" name="account.country"></td>
  </tr>
</table>

<h3>Profile Information</h3>

<table>
  <tr>
    <td>Language Preference:</td>
    <td>
      <select id="account.languagePreference" name="account.languagePreference">
        <option value="default">default</option>
      </select>
    </td>
  </tr>
  <tr>
    <td>Favourite Category:</td>
    <td>
      <stripes:select name="account.favouriteCategoryId">
      <stripes:options-collection collection="${sessionScope.account.categories}" />
      </stripes:select>
    </td>
  </tr>
  <tr>
    <td>Enable MyList</td>
    <td><input type="checkbox" name="account.listOption"></td>
  </tr>
  <tr>
    <td>Enable MyBanner</td>
    <td><input type="checkbox" name="account.bannerOption"></td>
  </tr>

</table>
