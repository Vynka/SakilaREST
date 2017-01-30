<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busqueda Actor</title>
    </head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <body>
        <table>
            <tr>
                <td>Nombre: <input type="text" id="txtNombre"> </td>
                <td>Apellidos: <input type="text" id="txtApellidos"> </td>
                <td><input type="button" value="submit" id="cmdSubmit"> </td>
            </tr>
        </table>
    </body>

    <script type="text/javascript">
        function refreshActorList() {
            var custList = $('#actorList');
            custList.empty();
            $.ajax({
                "url": "webresources/actor/",
                "type": "get",
                "dataType": "json",
                "success": function (actors) {
                    //console.log(actors);
                    $.each(actors, function (i, actor) {
                        var li = $('<li/>')
                                .addClass('ui-menu-item')
                                .attr('role', 'menuitem')
                                .appendTo(custList);
                        var a = $('<a/>')
                                .addClass('ui-all')
                                .text(actor.firstName + ' ' + actor.lastName)
                                .appendTo(li);
                    });
                }
            });
        }
        $(function () {
            refreshActorList();
        });
        $("#cmdSubmit").click(function (event) {
            var actor = {
                firstName: $("#txtNombre").val(),
                lastName: $("#txtApellidos").val()
            };
            var request = $.ajax({
                url: "webresources/actor/",
                type: "POST",
                contentType: 'application/json',
                data: JSON.stringify(actor),
                dataType: "json",
                success: function (data, textStatus, jqXHR) {
                    refreshActorList();
                }
            });
        });
    </script>
</html>