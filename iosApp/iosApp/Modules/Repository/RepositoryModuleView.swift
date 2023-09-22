//
//  RepositoryListScreen.swift
//  iosApp
//
//  Created by Vika on 18.08.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

fileprivate extension Appearance {
	var title: String { "Github Repos" }
}

struct RepositoryModuleView: View {
	@ObservedObject var viewModel: RepositoryViewModel
	
	private let appearance: Appearance = Appearance()
	
	var body: some View {
		listView()
	}
	
	private func listView() -> AnyView {
		switch viewModel.state {
		case .loading:
			return AnyView(LoaderView())
			
		case .result(let items):
			return AnyView (
				VStack {
					Section() {
						HStack {
							GithubLogoImage()
							Text(appearance.title)
						}
					}
					List {
						ForEach(items, id: \.self) { item in
							RepositoryListRow(item: item)
						}
					}
				}
			)
			
		case .error(let message):
			return AnyView(
				HStack {
					Text(message)
				}
			)
		}
	}
}

