/*
 Feature 1 - Image Preview
*/

var imageInput = document.getElementById("image");

if (imageInput)
{
    imageInput.addEventListener("change", function (event)
    {
        var file = event.target.files[0];

        if (file)
        {
            var reader = new FileReader();

            reader.onload = function (e)
            {
                var preview =
                document.getElementById("imagePreview");

                var container =
                document.getElementById("previewContainer");

                if (preview)
                {
                    preview.src = e.target.result;
                }

                if (container)
                {
                    container.style.display = "block";
                }
            };

            reader.readAsDataURL(file);
        }
    });
}


/*
 Feature 2 - Delete Confirmation
*/

function confirmDelete(name)
{
    return confirm(
    "Are you sure you want to delete "
    + name + " ?");
}


/*
 Feature 3 - Auto Hide Message
*/

var msg = document.getElementById("msg");

if (msg)
{
    setTimeout(function ()
    {
        msg.style.transition = "opacity 0.5s";

        msg.style.opacity = "0";

        setTimeout(function ()
        {
            msg.style.display = "none";

        }, 500);

    }, 3000);
}