<script>
    let userUrl = "";

    let shortenUrl = "";

    async function generateUrl() {
        const payload = {
            url: userUrl
        };
        const response = await fetch('http://localhost:8080/create', {
            method: 'POST',
            body: JSON.stringify(payload),
            headers: {
                'Content-Type': 'application/json'
            }
        });
    
        const { id } = await response.json();
    
        // shortenUrl = window.location.href + `${id}`;
        shortenUrl = `http://localhost:8080/${id}`;
    }

</script>

<h1>Welcome to smolurl!</h1>
<input bind:value={userUrl} placeholder="Please enter your url"/>
<button on:click={generateUrl}>Generate</button>
<h2>Your url is:</h2>
<div>
    <a href={shortenUrl}>{shortenUrl}</a>
</div>