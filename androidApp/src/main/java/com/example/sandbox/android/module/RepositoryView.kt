package com.example.sandbox.android.module

import RepositoryInfo
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.sandbox.android.R

@Composable
fun RepositoryModuleView(viewModel: RepositoryViewModel) {
    LaunchedEffect(Unit) {
        viewModel.loadData()
    }
    Scaffold(
        topBar = {
            RepositoryAppBar()
        }
    ) {
        Box {
            RepositoriesList(repositoryItems = viewModel.state.repositories) { itemId ->
                // onNavigationRequested(itemId)
            }
            if (viewModel.state.isLoading) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Composable
fun RepositoriesList(
    repositoryItems: List<RepositoryInfo>,
    onItemClicked: (id: String) -> Unit = { }
) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        this.items(repositoryItems) { item ->
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                RepositoryItemRow(item = item, onItemClicked = onItemClicked)
            }
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}

@Composable
fun RepositoryItemRow(
    item: RepositoryInfo,
    onItemClicked: (id: String) -> Unit = { }
) {
    val uriHandler = LocalUriHandler.current

    Row(modifier = Modifier.padding(10.dp)) {
        AsyncImage(
            model = item.owner.avatar,
            placeholder = painterResource(R.drawable.github),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.width(30.dp).height(30.dp).clip(CircleShape)
        )
        Column(modifier = Modifier.offset(10.dp)) {
            Text(text = item.owner.login)
            Spacer(modifier = Modifier.height(8.dp))

            ClickableText(
                text = AnnotatedString(item.name, ),
                onClick = {
                    uriHandler.openUri(item.url)
                },
                style = TextStyle(
                    color = Color.Blue
                )
            )
        }
    }
    
}
@Composable
fun RepositoryAppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.github),
                modifier = Modifier.padding(horizontal = 12.dp),
                contentDescription = "Github Repos"
            )
        },
        title = { Text("Github Repos") },
        backgroundColor = Color.LightGray
    )
}