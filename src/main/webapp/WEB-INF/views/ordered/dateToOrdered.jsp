<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>依日期查詢</title>
</head>
  <body>
    <table class="mytable" id="list_table_json">
      <thead>
        <input id="myday" type="date" />
        <tr>
          <th>Name</th>
          <th>Manufacturer</th>
        </tr>
      </thead>
    </table>
    <script>
      $(document).ready(function () {
        $('#myday').change(function () {
          var date = $(this).val();
          console.log(date, 'change');
          $.ajax({
            url: 'https://swapi.dev/api/starships/',
            dataType: 'json',
            type: 'get',
            cache: false,
            success: function (data) {
              /*console.log(data);*/
              var event_data = '';
              $.each(data.results, function (index, value) {
                /*console.log(value);*/
                event_data += '<tr>';
                event_data += '<td>' + value.name + '</td>';
                event_data += '<td>' + value.manufacturer + '</td>';
                event_data += '</tr>';
              });
              $('#list_table_json').append(event_data);
            },
            error: function (d) {
              /*console.log("error");*/
              alert('404. Please wait until the File is Loaded.');
            },
          });
        });
      });
    </script>
  </body>
</html>