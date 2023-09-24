package haw.bmaajp.groceriesapp.presentation.screen.explore

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import haw.bmaajp.groceriesapp.R
import haw.bmaajp.groceriesapp.domain.model.ProductItem
import haw.bmaajp.groceriesapp.presentation.common.card.CategoryCard
import haw.bmaajp.groceriesapp.presentation.component.SearchViewBar
import haw.bmaajp.groceriesapp.presentation.screen.explore.ui.theme.GroceriesAppTheme
import haw.bmaajp.groceriesapp.presentation.screen.home.HomeViewModel
import haw.bmaajp.groceriesapp.ui.theme.Black
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_10dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_12dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_16dp
import haw.bmaajp.groceriesapp.ui.theme.GilroyFontFamily
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_18sp
import haw.bmaajp.groceriesapp.utils.DataDummy
import haw.bmaajp.groceriesapp.utils.showToastShort

@Composable
fun FruitScreen(
    modifier: Modifier = Modifier
) {
    Scaffold { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues)
        ) {
            androidx.compose.material.Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = DIMENS_16dp),
                text = stringResource(R.string.find_products),
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = TEXT_SIZE_18sp,
                color = Black
            )

            SearchViewBar(hint = stringResource(id = R.string.search_category))

            LazyVerticalGrid(
                modifier = Modifier.padding(start = DIMENS_16dp, end = DIMENS_16dp),
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(DIMENS_10dp),
                horizontalArrangement = Arrangement.spacedBy(DIMENS_12dp),
            ) {
                items(DataDummy.generateDummyFruits()) { categoryItem ->
                    CategoryCard(categoryItem = categoryItem)
                }
            }
        }
    }
}

@Preview
@Composable
fun FruitScreenPreview() {
    FruitScreen()
}


fun clickToCart(context: Context, productItem: ProductItem, viewModel: HomeViewModel) {
    context.showToastShort("Success Add To Cart ${productItem.title}")
    viewModel.addCart(productItem.copy(isCart = true))
}