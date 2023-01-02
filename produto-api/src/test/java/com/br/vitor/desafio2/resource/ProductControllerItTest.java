package com.br.vitor.desafio2.resource;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureTestDatabase
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//@AutoConfigureMockMvc
//@Transactional
public class ProductControllerItTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Value("${security.oauth2.client.client-id}")
//    private String clientId;
//
//    //@Mock
//    //private ObjectMapper objectMapper;
//    @Value("${security.oauth2.client.client-secret}")
//    private String clientSecret;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    private String adminUsername;
//    private String adminPassword;
//
//    private Product product;
//
//    @BeforeEach
//    void setUp() throws Exception {
//
//        adminUsername = "admin";
//        adminPassword = "12345";
//
//        product = new Product();
//        product.setName("teste");
//        product.setCategory("teste");
//        product.setPrice(new BigDecimal(1000));
//
//    }
//
//
//    private String obtainAccessToken(String username, String password) throws Exception {
//
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("grant_type", "password");
//        params.add("client_id", clientId);
//        params.add("username", username);
//        params.add("password", password);
//
//        ResultActions result = mockMvc
//                .perform(post("/oauth/token").params(params).with(httpBasic(clientId, clientSecret))
//                        .accept("application/json;charset=UTF-8"))
//                .andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));
//
//        String resultString = result.andReturn().getResponse().getContentAsString();
//
//        JacksonJsonParser jsonParser = new JacksonJsonParser();
//        return jsonParser.parseMap(resultString).get("access_token").toString();
//    }
//
//    @Test
//    public void testsIfYouMakeTheRequestWithoutPassingTheAuthorizationToken() throws Exception {
//
//        ResultActions result =
//                mockMvc.perform(get("/api/products")
//                        .contentType(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isUnauthorized());
//
//    }
//
//    @Test
//    public void testsTheReturnOfTheGetAllMethod() throws Exception {
//
//        String accessToken = obtainAccessToken(adminUsername, adminPassword);
//
//        ResultActions result =
//                mockMvc.perform(get("/api/products")
//                        .header("Authorization", "Bearer " + accessToken)
//                        .contentType(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isOk());
//    }
//
//    @Test
//    public void testsTheReturnOfTheGetByIdMethod() throws Exception {
//
//        String accessToken = obtainAccessToken(adminUsername, adminPassword);
//
//        ResultActions result =
//                mockMvc.perform(get("/api/products/1")
//                        .header("Authorization", "Bearer " + accessToken)
//                        .contentType(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isOk());
//    }
//
//    @Test
//    public void testsTheReturnByPassingAnInvalidId() throws Exception {
//
//        String accessToken = obtainAccessToken(adminUsername, adminPassword);
//
//        ResultActions result =
//                mockMvc.perform(get("/api/products/100")
//                        .header("Authorization", "Bearer " + accessToken)
//                        .contentType(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void testsTheReturnOfTheDeleteMethod() throws Exception {
//
//        String accessToken = obtainAccessToken(adminUsername, adminPassword);
//
//        ResultActions result =
//                mockMvc.perform(delete("/api/products/1")
//                        .header("Authorization", "Bearer " + accessToken)
//                        .contentType(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void testDeleteReturnByPassingAnInvalidId() throws Exception {
//
//        String accessToken = obtainAccessToken(adminUsername, adminPassword);
//
//        ResultActions result =
//                mockMvc.perform(delete("/api/products/100")
//                        .header("Authorization", "Bearer " + accessToken)
//                        .contentType(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isNotFound());
//    }
//
//    @Test
//    void testsTheInsertionMethodPassingValidProduct() throws Exception {
//
//        String accessToken = obtainAccessToken(adminUsername, adminPassword);
//
//        String jsonBody = new Gson().toJson(product);
//
//
//        ResultActions result =
//                mockMvc.perform(post("/api/products")
//                        .header("Authorization", "Bearer " + accessToken)
//                        .content(jsonBody)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isCreated());
//    }
//
//    @Test
//    void testsTheInsertionMethodPassingInvalidProduct() throws Exception {
//
//        String accessToken = obtainAccessToken(adminUsername, adminPassword);
//
//        String jsonBody = new Gson().toJson(ProductCreator.createProductWithAllAttributesNoName());
//
//
//        ResultActions result =
//                mockMvc.perform(post("/api/products")
//                        .header("Authorization", "Bearer " + accessToken)
//                        .content(jsonBody)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isNotFound());
//    }
//
//    @Test
//    void testsTheUpdateMethodPassingValidProduct() throws Exception {
//
//        String accessToken = obtainAccessToken(adminUsername, adminPassword);
//
//        String jsonBody = new Gson().toJson(product);
//
//
//        ResultActions result =
//                mockMvc.perform(put("/api/products/1")
//                        .header("Authorization", "Bearer " + accessToken)
//                        .content(jsonBody)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isOk());
//    }
//
//    @Test
//    void testsTheUpdateMethodPassingInvalidProduct() throws Exception {
//
//        String accessToken = obtainAccessToken(adminUsername, adminPassword);
//
//        String jsonBody = new Gson().toJson(ProductCreator.createProductWithAllAttributesNoName());
//
//
//        ResultActions result =
//                mockMvc.perform(put("/api/products/1")
//                        .header("Authorization", "Bearer " + accessToken)
//                        .content(jsonBody)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isNotFound());
//    }

}
