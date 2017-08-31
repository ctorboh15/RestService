function openModalPopup(url)
{
    $.get(url, function(data, status)
    {
           $("div#modalBody").html(data);
    });
    $('#appModal').modal('show');
}