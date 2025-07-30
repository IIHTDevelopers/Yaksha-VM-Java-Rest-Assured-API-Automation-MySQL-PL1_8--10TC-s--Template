package rest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import io.restassured.response.Response;

public class ApiUtil {
	private static final Set<Integer> usedNumbers = new HashSet<>();
	private static final Random random = new Random();
	private static String BASE_URL;
	Properties prop;

	/**
	 * Retrieves the base URL from the configuration properties file.
	 *
	 * <p>
	 * This method loads the properties from the file located at
	 * <code>{user.dir}/src/main/resources/config.properties</code> and extracts the
	 * value associated with the key <code>base.url</code>. The value is stored in
	 * the static variable <code>BASE_URL</code> and returned.
	 *
	 * @return the base URL string if successfully read from the properties file;
	 *         {@code null} if an I/O error occurs while reading the file.
	 */
	public String getBaseUrl() {
		prop = new Properties();
		try (FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties")) {
			prop.load(fis);
			BASE_URL = prop.getProperty("base.url");
			return BASE_URL;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Retrieves the username from the configuration properties file.
	 *
	 * <p>
	 * This method reads the properties from the file located at
	 * <code>{user.dir}/src/main/resources/config.properties</code> and returns the
	 * value associated with the key <code>username</code>.
	 *
	 * @return the username as a {@code String} if found in the properties file;
	 *         {@code null} if an I/O error occurs while reading the file.
	 */
	public String getUsername() {
		prop = new Properties();
		try (FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties")) {
			prop.load(fis);
			return prop.getProperty("username");
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getPassword() {
		prop = new Properties();
		try (FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties")) {
			prop.load(fis);
			return prop.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Retrieves the password from the configuration properties file.
	 *
	 * <p>
	 * This method loads the properties from the file located at
	 * <code>{user.dir}/src/main/resources/config.properties</code> and returns the
	 * value associated with the key <code>password</code>.
	 *
	 * @return the password as a {@code String} if found in the properties file;
	 *         {@code null} if an I/O error occurs while reading the file.
	 */
	public static String generateUniqueName(String base) {
		int uniqueNumber;
		do {
			uniqueNumber = 1000 + random.nextInt(9000);
		} while (usedNumbers.contains(uniqueNumber));

		usedNumbers.add(uniqueNumber);
		return base + uniqueNumber;
	}

	public static int generateUniqueID(int base) {
		int uniqueNumber;
		do {
			uniqueNumber = 1000 + random.nextInt(9000);
		} while (usedNumbers.contains(uniqueNumber));

		usedNumbers.add(uniqueNumber);
		return base + uniqueNumber;
	}

	/**
	 * Sends a GET request to the specified endpoint with a cookie and optional
	 * request body.
	 *
	 * <p>
	 * This method uses RestAssured to construct and send a GET request to the given
	 * endpoint. It attaches a cookie named <code>orangehrm</code> with the provided
	 * value and sets the <code>Content-Type</code> header to
	 * <code>application/json</code>. If a request body is provided, it is included
	 * in the request.
	 *
	 * @param endpoint    the API endpoint to send the request to (relative to the
	 *                    base URL)
	 * @param cookieValue the value of the <code>orangehrm</code> cookie to include
	 *                    in the request
	 * @param body        a map containing key-value pairs to be sent as the JSON
	 *                    request body (can be null)
	 * @return the response received from the GET request
	 */
	public CustomResponse GetHolidayData(String endpoint, String cookieValue, Map<String, String> body) {

		Response response = null;

		int statusCode = 0;
		String status = null;

		List<Object> ids = null;
		List<Object> names = null;
		List<Object> dates = null;
		List<Object> recurrings = null;
		List<Object> lengths = null;
		List<Object> lengthNames = null;

		return new CustomResponse(response, statusCode, status, ids, names, dates, recurrings, lengths, lengthNames);
	}

	/**
	 * Sends a GET request to the specified endpoint with a cookie and optional
	 * request body.
	 *
	 * <p>
	 * This method constructs a GET request using RestAssured, attaching a cookie
	 * named <code>orangehrm</code> with the specified value and setting the
	 * <code>Content-Type</code> header to <code>application/json</code>. If a body
	 * is provided, it is included in the request.
	 *
	 * @param endpoint    the relative URL endpoint to send the GET request to
	 * @param cookieValue the value for the <code>orangehrm</code> cookie
	 * @param body        a map of key-value pairs representing the request body
	 *                    (optional, may be null)
	 * @return the response received from the GET request
	 */
	public CustomResponse GetLeaveData(String endpoint, String cookieValue, Map<String, String> body) {

		Response response = null;

		int statusCode = 0;
		String status = null;

		List<Object> ids = null;
		List<Object> names = null;
		List<Object> dates = null;
		List<Object> recurrings = null;
		List<Object> lengths = null;
		List<Object> lengthNames = null;

		return new CustomResponse(response, statusCode, status, ids, names, dates, recurrings, lengths, lengthNames);
	}

	/**
	 * Executes a GET request to the given endpoint using a specified cookie and
	 * optional request body.
	 *
	 * <p>
	 * This method prepares a GET request with RestAssured, attaching a cookie named
	 * <code>orangehrm</code> with the provided value and setting the request header
	 * <code>Content-Type</code> to <code>application/json</code>. If the request
	 * body is not null, it is included in the request payload.
	 *
	 * @param endpoint    the API endpoint to target, appended to the base URL
	 * @param cookieValue the value for the <code>orangehrm</code> cookie
	 * @param body        a map containing key-value pairs to be used as the request
	 *                    body (optional)
	 * @return the response object resulting from the GET request
	 */

	public CustomResponse GetEmpCount(String endpoint, String cookieValue, Map<String, String> body) {
		Response response = null;

		int statusCode = 0;
		String status = null;

		int count = 0;

		return new CustomResponse(response, statusCode, status, count); // ⬅️ return single count
	}

	/**
	 * Sends a GET request to the specified API endpoint with an authentication
	 * cookie and optional body.
	 *
	 * <p>
	 * This method utilizes RestAssured to perform a GET request to the provided
	 * endpoint. It includes a cookie named <code>orangehrm</code> with the
	 * specified value and sets the <code>Content-Type</code> to
	 * <code>application/json</code>. If a request body is provided, it is attached
	 * to the request.
	 *
	 * @param endpoint    the relative endpoint path to be appended to the base URL
	 * @param cookieValue the value of the <code>orangehrm</code> cookie for session
	 *                    handling or authentication
	 * @param body        a map containing request body parameters (optional; may be
	 *                    null)
	 * @return the {@code Response} object containing the results of the GET request
	 */
	public CustomResponse DeletePim(String deleteEndPoint, String cookieValue, String requestBody) {

		Response response = null;
		int statusCode = 0;
		String status = null;
		Object dataValue = null;

		return new CustomResponse(response, statusCode, status, dataValue);
	}

	/**
	 * Sends a GET request to the specified API endpoint with an authentication
	 * cookie and optional body.
	 *
	 * <p>
	 * This method utilizes RestAssured to perform a GET request to the provided
	 * endpoint. It includes a cookie named <code>orangehrm</code> with the
	 * specified value and sets the <code>Content-Type</code> to
	 * <code>application/json</code>. If a request body is provided, it is attached
	 * to the request.
	 *
	 * @param endpoint    the relative endpoint path to be appended to the base URL
	 * @param cookieValue the value of the <code>orangehrm</code> cookie for session
	 *                    handling or authentication
	 * @param body        a map containing request body parameters (optional; may be
	 *                    null)
	 * @return the {@code Response} object containing the results of the GET request
	 */

	public CustomResponse GetLeaveType(String endpoint, String cookieValue, Map<String, String> body) {

		Response response = null;

		int statusCode = 0;
		String status = null;

		List<Object> ids = null;
		List<Object> names = null;
		List<Object> situationals = null;
		List<Object> Deletes = null;

		return new CustomResponse(response, statusCode, status, ids, names, situationals, Deletes);
	}

	/**
	 * Performs a GET request to the specified endpoint with a provided cookie and
	 * optional request body.
	 *
	 * <p>
	 * This method constructs a GET request using RestAssured, sets the
	 * <code>Content-Type</code> header to <code>application/json</code>, and
	 * includes a cookie named <code>orangehrm</code>. If the provided body map is
	 * not null, it is added to the request as the JSON payload.
	 *
	 * @param endpoint    the API endpoint to which the GET request will be sent,
	 *                    appended to the base URL
	 * @param cookieValue the value of the <code>orangehrm</code> cookie used for
	 *                    session or auth
	 * @param body        a map of key-value pairs representing the request body
	 *                    (optional; may be null)
	 * @return the {@link io.restassured.response.Response} object containing the
	 *         server's response
	 */
	public CustomResponse GetUsageReport(String endpoint, String cookieValue, Map<String, String> body) {

		Response response = null;

		int statusCode = 0;
		String status = null;

		List<Object> names = null;
		List<Object> props = null;
		List<Object> sizes = null;
		List<Object> pins = null;
		List<Object> cellProperties = null; // Keep it List<Object> for flexibility in CustomResponse

		return new CustomResponse(response, statusCode, status, props, names, sizes, pins, cellProperties);
	}

	/**
	 * Sends a PUT request to the specified endpoint with a cookie and optional
	 * request body.
	 *
	 * <p>
	 * This method constructs a PUT request using RestAssured, sets the
	 * <code>Content-Type</code> header to <code>application/json</code>, and
	 * includes a cookie named <code>orangehrm</code>. If a request body is
	 * provided, it is attached to the request.
	 *
	 * @param endpoint    the relative endpoint to which the PUT request is sent,
	 *                    appended to the base URL
	 * @param cookieValue the value of the <code>orangehrm</code> cookie for session
	 *                    or authorization purposes
	 * @param requestBody an object representing the request body (can be null)
	 * @return the {@link io.restassured.response.Response} returned from the PUT
	 *         request
	 */
	public CustomResponse PutTerminationReason(String endpoint, String cookieValue, String requestBody) {

		Response response = null;

		int statusCode = 0;
		String status = null;

		Object id = null;
		Object name = null;

		return new CustomResponse(response, statusCode, status, id, name);
	}

	/**
	 * Sends a POST request to the specified endpoint with a cookie and JSON string
	 * payload.
	 *
	 * <p>
	 * This method uses RestAssured to perform a POST request to the given endpoint.
	 * It sets the <code>Content-Type</code> header to
	 * <code>application/json</code>, includes a cookie named
	 * <code>orangehrm</code>, and attaches the provided JSON string as the request
	 * body.
	 *
	 * @param endpoint    the relative URL endpoint for the POST request, appended
	 *                    to the base URL
	 * @param cookieValue the value of the <code>orangehrm</code> cookie used for
	 *                    authentication or session handling
	 * @param body        a JSON-formatted string representing the request payload
	 * @return the {@link io.restassured.response.Response} object containing the
	 *         server's response
	 */
	public CustomResponse PostPimEmp(String endpoint, String cookieValue, String requestBody) {

		Response response = null;

		int statusCode = 0;
		String status = null;

		Object firstName = null;
		Object employeeId = null;

		return new CustomResponse(response, statusCode, status, employeeId, firstName);
	}

	public CustomResponse DeletePimEmp(String endpoint, String cookieValue, String requestBody) {

		Response response = null;

		int statusCode = 0;
		String status = null;

		Object employeeId = null;

		return new CustomResponse(response, statusCode, status, employeeId, employeeId);
	}
}
