function oneColumn(a,b,c, bc, c0) {
    var string  = a + "<span>x</span><sup>2</sup>" + bc + b + "x" + c0 + c + " = 0";
    return string;
}
function deleteRowListener(){
    $("tbody tr:first").click(function () {
        this.remove();
    })
}


$(document).ready(function(){
    $("#form").submit(function() {
        $.ajax({
            url: '/servlet',
            type: 'post',
            dataType : 'text',
            data: $("#form").serialize(),
            success : function (data) {
                $('#table tbody').prepend("<tr><td>" + oneColumn(data.a,data.b,data.c,data.bc,data.c0) + "</td><td>" + data.answer + "</td></tr>");
                $("#a,#b,#c").val(null);
                $("#a,#b,#c").val(null);
                deleteRowListener();
            }
        });
        return false;
    })
});
