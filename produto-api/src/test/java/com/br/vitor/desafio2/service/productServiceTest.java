package com.br.vitor.desafio2.service;

//@ExtendWith(SpringExtension.class)
public class productServiceTest {
//
//
//    @InjectMocks
//    private ProductService productService;
//    @Mock
//    private ProductRepository productRepositoryMock;
//    @Mock
//    private ProductMapper productMapper;
//
//    @BeforeEach
//    void setUp() {
//        PageImpl<Product> productPage = new PageImpl<>(List.of(ProductCreator.createProductWithAllAttributesFakerMinusTheName()));
//        BDDMockito.when(productRepositoryMock.findAll(ArgumentMatchers.any(PageRequest.class)))
//                .thenReturn(productPage);
//
//        BDDMockito.when(productRepositoryMock.findById(ArgumentMatchers.anyLong()))
//                .thenReturn(Optional.of(ProductCreator.createProductWithAllAttributes()));
//
//        BDDMockito.doNothing().when(productRepositoryMock).delete(ArgumentMatchers.any(Product.class));
//
//    }
//
//    @Test
//    void testReturnListOfProductsInsidePageService() {
//        String expectedName = ProductCreator.createProductWithAllAttributesFakerMinusTheName().getName();
//
//        Page<Product> productPage = productService.listAll(PageRequest.of(1, 1));
//
//        Assertions.assertThat(productPage).isNotNull();
//
//        Assertions.assertThat(productPage.toList())
//                .isNotEmpty()
//                .hasSize(1);
//
//        Assertions.assertThat(productPage.toList().get(0).getName()).isEqualTo(expectedName);
//    }
//
//    @Test
//    void testProductFindByIdService() {
//        Long expectedId = ProductCreator.createProductWithAllAttributes().getId();
//
//        Product product = productService.findById(1L);
//
//        Assertions.assertThat(product).isNotNull();
//
//        Assertions.assertThat(product.getId()).isNotNull().isEqualTo(expectedId);
//    }
//
//    @Test
//    void testFindByIdIncorrectProduct() {
//        Long expectedId = ProductCreator.createProductWithAllAttributes().getId();
//
//        Product product = productService.findById(1L);
//        product.setId(2L);
//        Assertions.assertThat(product).isNotNull();
//
//        Assertions.assertThat(product.getId()).isNotNull().isNotEqualTo(expectedId);
//    }
//
//    @Test
//    void testInsertService() {
//        Product productSave = ProductCreator.createProductWithAllAttributesFakerMinusTheName();
//
//        var response = productService.insert(productSave);
//
//        Assertions.assertThat(productSave).isNotNull();
//        Assertions.assertThat(productSave.getName()).isEqualTo("teste");
//    }
//
//    @Test
//    void testDeleteProductService() {
//
//        Assertions.assertThatCode(() -> productService.delete(1L))
//                .doesNotThrowAnyException();
//
//    }
//
//    @Test
//    void testUpdateDataService() {
//        var p1 = ProductCreator.createProductWithAllAttributesFakerMinusTheName();
//        var p2 = ProductCreator.createProductWithAllAttributes();
//
//        productService.updateData(p1, p2);
//
//        Assertions.assertThat(p1.toString()).isEqualTo(p2.toString());
//    }
//
//    @Test
//    void testExtractExtensionService() {
//        String extension = productService.extractExtension("teste.csv");
//
//        Assertions.assertThat(extension).isEqualTo("csv");
//    }

}
