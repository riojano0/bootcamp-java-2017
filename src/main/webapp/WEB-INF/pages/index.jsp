<html>
    <title>Hello!</title>
    <body>
      <h1>Bootcamp java 2017</h1>
      <h2> GET: </h2>

      <h3>State</h3>
      <ul>
          <li><a href="/state/get/all">/state/get/all</a>  </li>
          <li><a href="/state/get/id/{id}">/state/get/id/{id}</a> </li>
          <li><a href="/state/get/name/{name}">state/get/name/{name} </a> </li>
      </ul>

      <h3>Country</h3>
      <ul>
          <li><a href="/country/get/all">/country/get/all</a> </li>
          <li><a href="/country/get/id/{id}">/country/get/id/{id}</a> </li>
          <li><a href="/country/get/name/{name}">/country/get/name/{name} </a> </li>
      </ul>

      <h3>Weather</h3>
      <ul>
          <li><a href="/weather/get/all">/weather/get/all</a> </li>
          <li><a href="/weather/state/{stateName}?date={}">/weather/state/{stateName}?date={}</a><code>Date is optional</code></li>
      </ul>

      <h2>POST:</h2>
        <ul>
            <li><a href="/country/new">/country/new</a> </li>
            <li><a href="/state/new">/state/new</a> </li>
            <li><a href="/weather/new">/weather/new</a> </li>
        </ul>

    </body>
</html>