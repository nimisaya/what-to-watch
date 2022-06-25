package com.haxman.whattowatch.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.haxman.whattowatch.R


@Composable
fun SearchScreen(padding: PaddingValues) {
    var text by remember { mutableStateOf("") }
    val searchHeight: Dp = 56.dp

    Surface(modifier = Modifier.padding(padding)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            SearchHeading(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(R.string.app_name),
            )
            Spacer(modifier = Modifier.height(32.dp))
            SearchField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(searchHeight),
                inputText = text
            )
            Spacer(modifier = Modifier.height(16.dp))
            SearchButton(modifier = Modifier
                .fillMaxWidth()
                .height(searchHeight),
                onClick = {}
            )
        }
    }

}

@Composable
fun SearchField(modifier: Modifier = Modifier, inputText: String) {
    var text by remember { mutableStateOf(TextFieldValue(inputText)) }

    TextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = stringResource(R.string.search_field_label)) },
        shape = RoundedCornerShape(32),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            //TODO Uncomment to change search field colour
            // containerColor = Color.White
        ),
        placeholder = { Text(text = stringResource(R.string.search_field_placeholder)) },
        singleLine = true,
        onValueChange = {
            text = it
        }
    )
}

@Composable
fun SearchHeading(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headlineLarge,
        textAlign = textAlign
    )
}

@Composable
fun SearchButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(percent = 32),
    ) {
        Text(
            text = stringResource(R.string.search_button_label),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@Preview(showBackground = true, name = "Search Screen", showSystemUi = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen(PaddingValues(0.dp))
}